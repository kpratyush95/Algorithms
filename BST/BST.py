class Node():
    def __init__(self,value):
        self.left = None
        self.right = None
        self.key = value
        self.parent = None

def  Tree_Search(node,value):
    if ((node==None) or (node.key == value)):
        return node
    if(value<node.key):
        return Tree_Search(node.left,value)
    else:
        return Tree_Search(node.right,value)

def Tree_Minimum(node):
    while node.left!=None:
        node = node.left
    return node

def Tree_Maximum(node):
    while node.right!=None:
        node=node.right
    return node

def Tree_Successor(node):
    if node.right!=None:
        return Tree_Successor(node.right)
    walker = node.parent
    while((walker!=None) and (node==walker.right)):
        node=walker
        walker = walker.parent
    return walker

def Tree_Predecessor(node):
    if node.left!=None:
        return Tree_Predecessor(node.left)
    walker=node.parent
    while((walker!=None) and (node==walker.left)):
        node=walker
        walker=walker.parent
    return walker

def Tree_Insert(T,node):
    holder =None
    walker = T.root
    while walker!=None:
        holder=walker
        if(node.key<walker.key):
            walker=walker.left
        else:
            walker=walker.left
    node.parent = walker
    if holder==None:    #tree is empty
        T.root = node
        return
    elif node.key <holder.key:
        holder.left = node
        return
    else:
        holder.right = node
        return

def Inorder_Travaersal(root):
    if(root is not None):
        Inorder_Travaersal(root.left)
        print(root.key)
        Inorder_Travaersal(root.right)

