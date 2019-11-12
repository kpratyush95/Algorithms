class Node():
    def __init__(self, value):
        self.left = None
        self.right = None
        self.key = value
        self.parent = None


class Tree():
    def __init__(self):
        self.root = None

    def Tree_Search(self, value):
        if (self.root == None) or (self.root.key == value):
            return self.root
        if (value < self.root.key):
            return self.Tree_Search(self.root.left, value)
        else:
            return self.Tree_Search(self.root.right, value)

    def Tree_Minimum(self, node):
        while node.left != None:
            node = node.left
        return node

    def Tree_Maximum(self, node):
        while node.right != None:
            node = node.right
        return node

    def Tree_Successor(self, node):
        if node.right != None:
            return self.Tree_Successor(node.right)
        walker = node.parent
        while ((walker != None) and (node == walker.right)):
            node = walker
            walker = walker.parent
        return walker

    def Tree_Predecessor(self, node):
        if node.left is not None:
            return self.Tree_Predecessor(node.left)
        walker = node.parent
        while (walker is not None) and (node == walker.left):
            node = walker
            walker = walker.parent
        return walker

    def Tree_Insert(self, node):
        holder = None
        walker = self.root
        while walker != None:
            holder = walker
            if (node.key < walker.key):
                walker = walker.left
            else:
                walker = walker.right
        node.parent = holder
        if holder == None:  # tree is empty
            self.root = node
            return
        elif node.key < holder.key:
            holder.left = node
            return
        else:
            holder.right = node
            return

    def Inorder_Travaersal(self, root):
        if (root is not None):
            self.Inorder_Travaersal(root.left)
            print(root.key)
            self.Inorder_Travaersal(root.right)

    def Print_parent(self, node):
        if (node.parent != None):
            parent_value = node.parent.key
            print(str(parent_value) + " is the parent of " + str(node.key))
        else:
            print("None")

    def Transplant(self, node1, node2):
        if node1.parent is None:
            self.root = node2
        elif (node1 == node1.parent.left):
            node1.parent.left = node2
        else:
            node1.parent.right = node2
        if (node2 is not None):
            node2.parent = node1.parent

    def Tree_Delete(self, node):
        if node.left is None:
            self.Transplant(node, node.right)
        elif node.right is None:
            self.Transplant(node, node.left)
        else:
            walker = self.Tree_Minimum(node.right)
            if walker.parent != node:
                self.Transplant(walker, walker.right)
                walker.right = node.right
            self.Transplant(node, walker)
            walker.left = node.left
            walker.left.parent = walker


T = Tree()
a = Node(7)
b = Node(64)
c = Node(75)
d = Node(32)
e = Node(2)
T.Tree_Insert(a)
T.Tree_Insert(b)
T.Tree_Insert(c)
T.Tree_Insert(d)
T.Tree_Insert(e)
T.Print_parent(a)
T.Print_parent(b)
T.Print_parent(c)
T.Print_parent(d)
T.Print_parent(e)
T.Inorder_Travaersal(T.root)
