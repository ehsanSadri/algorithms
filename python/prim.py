import heapq

def prim(graph, start):
    mst = []  # لیست یال‌های درخت پوشای کمینه
    visited = set()  # مجموعه‌ای از گره‌های بازدیدشده
    min_heap = [(0, start, -1)]  # (هزینه، گره فعلی، گره قبلی)

    while min_heap:
        weight, current, prev = heapq.heappop(min_heap)
        if current in visited:
            continue
        visited.add(current)
        if prev != -1:
            mst.append((prev, current, weight))

        for neighbor, edge_weight in graph[current]:
            if neighbor not in visited:
                heapq.heappush(min_heap, (edge_weight, neighbor, current))

    return mst

# مثال تست
if __name__ == "__main__":
    graph = {
        0: [(1, 4), (7, 8)],
        1: [(0, 4), (7, 11), (2, 8)],
        2: [(1, 8), (8, 2), (5, 4), (3, 7)],
        3: [(2, 7), (5, 14), (4, 9)],
        4: [(3, 9), (5, 10)],
        5: [(4, 10), (3, 14), (2, 4), (6, 2)],
        6: [(5, 2), (7, 1), (8, 6)],
        7: [(0, 8), (1, 11), (8, 7), (6, 1)],
        8: [(2, 2), (7, 7), (6, 6)]
    }
    mst = prim(graph, 0)
    for u, v, w in mst:
        print(f"{u} - {v}: {w}")