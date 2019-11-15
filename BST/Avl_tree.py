import random, math

outputdebug =False
def debug(msg):
    if outputdebug:
        print (msg)

class Node:
    def __init__(self, value):
        self.left = None
        self.right = None
        self.key = value


class Tree:
    def __init__(self, *args):
        self.node = None
        self.height = -1
        self.balance = 0

        if len(args)==1:
            for i in args[0]:
                self.insert(i)

    def get_height(self):
        if self.node:
            return self.node.height
        else:
            return 0

    def is_leaf(self):
        return (self.height == 0)

    def Insert(self, key):
        tree= self.node
        new_node = Node(key)
        if(tree is None):
            self.node = new_node
            self.node.left = Tree()
            self.node.right = Tree()
        elif key< tree.key:
            self.node.left.insert(key)
        elif key> tree.key:
            self.node.left.insert(key)
        else:
            debug("Key ["+str(key)+"] is already in tree")
        self.rebalance()

    def rebalance(self):
