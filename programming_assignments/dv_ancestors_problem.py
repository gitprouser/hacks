data = [(1,2,3)...]

tree = {k: (p1, p2) for k, p1, p2 in data}

def has_common_ancestor (id1, id2):
  if id1 == id2:
    return True
  state = [(0, id1), (1, id2),]
  parents = [set (), set ()]
  for side, id in state:
    for parent in tree[id]:
      if parent in parents[0 if side else 1]:
        return True
      if parent and parent not in parents[0 if side else 1]:
        parents[side].add ((side, parent))
  return False
