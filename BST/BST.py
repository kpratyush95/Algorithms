def  Tree_search(node,value):
    if ((node==None) or (node.key == value)):
        return node
        if(value<node.key):
            return Tree_search(node.left,value)
        else:
            return Tree_search(node.right,value)

def Tree_minimum(node):
    while node.left!=None:
        node = node.left
    return node

def Tree_maximum(node):
    while node.right!=None:
        node=node.right
    return node

def Tree_successor(node):
    if node.right!=None:
        return Tree_successor(node.right):
    y = node.parent
    while((y!=None) and (node==y.right)):
        node=y
        y = y.parent
    return y

def Tree_Predecessor(node):
    if node.left!=None:
        return Tree_Predecessor(node.left)
    y=node.parent
    while((y!=None) and (node==y.left)):
        node=y
        y=y.parent
    return y

