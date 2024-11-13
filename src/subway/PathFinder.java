package subway;

import java.util.*;
import java.util.function.Function;

public class PathFinder {

    // 최단 거리 기준으로 경로를 찾는 메서드
    public List<Station> findPathByShortestDistance(Station start, Station end, List<Line> lines) {
        return findPath(start, end, lines, Route::getDistance);
    }

    // 최단 시간 기준으로 경로를 찾는 메서드
    public List<Station> findPathByShortestTime(Station start, Station end, List<Line> lines) {
        return findPath(start, end, lines, Route::getTime);
    }

    // 공통 경로 탐색 로직 (비용 함수(costFunction)를 기준으로 다익스트라 알고리즘 적용)
    private List<Station> findPath(Station start, Station end, List<Line> lines, Function<Route, Integer> costFunction) {
        // 각 역에 대한 최소 비용 정보를 저장하는 맵
        Map<Station, Integer> costs = new HashMap<>();
        // 최단 경로를 추적하기 위한 이전 역 정보 저장
        Map<Station, Station> previous = new HashMap<>();

        // 우선순위 큐(비용이 낮은 순으로 정렬)
        PriorityQueue<RouteNode> pq = new PriorityQueue<>(Comparator.comparingInt(RouteNode::getCost));

        // 모든 역의 초기 비용을 무한대로 설정
        for (Line line : lines) {
            for (Route route : line.getRoutes()) {
                costs.put(route.getStart(), Integer.MAX_VALUE);
                costs.put(route.getEnd(), Integer.MAX_VALUE);
            }
        }
        costs.put(start, 0); // 시작 역의 비용은 0으로 설정
        pq.add(new RouteNode(start, 0)); // 우선순위 큐에 시작 역 추가

        // 다익스트라 알고리즘 실행
        while (!pq.isEmpty()) {
            RouteNode currentNode = pq.poll(); // 가장 낮은 비용의 노드를 큐에서 가져옴
            Station currentStation = currentNode.getStation();

            // 저장된 최소 비용보다 큰 경우는 무시 (이미 더 나은 경로를 찾음)
            if (currentNode.getCost() > costs.get(currentStation)) {
                continue;
            }

            // 현재 역과 연결된 모든 경로를 탐색
            for (Line line : lines) {
                for (Route route : line.getRoutes()) {
                    if (!route.getStart().equals(currentStation)) {
                        continue; // 현재 역에서 시작되지 않는 경로는 건너뜀
                    }

                    Station neighbor = route.getEnd(); // 연결된 다음 역
                    int newCost = costs.get(currentStation) + costFunction.apply(route); // 새로운 비용 계산

                    // 더 낮은 비용이 발견되면 갱신
                    if (newCost < costs.get(neighbor)) {
                        costs.put(neighbor, newCost); // 비용 갱신
                        previous.put(neighbor, currentStation); // 이전 역 갱신
                        pq.add(new RouteNode(neighbor, newCost)); // 우선순위 큐에 추가
                    }
                }
            }
        }

        // 경로를 역추적하여 리스트에 추가
        List<Station> path = new ArrayList<>();
        for (Station at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path); // 경로를 올바른 순서로 뒤집음

        // 유효한 경로가 없는 경우 예외 발생
        if (path.isEmpty() || !path.get(0).equals(start)) {
            throw new IllegalArgumentException("[ERROR] 도달할 수 있는 경로가 없습니다.");
        }

        return path; // 최종 경로 반환
    }

}
