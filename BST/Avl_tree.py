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

    def update_heights(self, recurse=True):
        if not self.node is None:
            if recurse:
                if self.node.left!=None:
                    self.node.left.update_heights()
                if self.node.right!=None:
                    self.node.right.update_heights()
            self.height = max(self.node.left.height, self.node.left.height)+1
        else:
            self.height = -1
    def update_balances(self,recurse=True):
        if not self.node==None:
            if recurse:
                if self.node.left !=None:
                    self.node.left.update_balances()
                if self.node.right !=None:
                    self.node.right.update_balances()
            self.balance = self.node.left.height -self.node.right.height
        else:
            self.balance=0

    def lrotate(self):
        A = self.node
        B = self.node.right.node
        T = B.left.node
        self.node = B
        B.left.node = A
        A.right.node = T

    def rrotate(self):
        A = self.node
        B =self.node.left.node
        T = B.right.node

        self.node= B
        B.right.node =A
        A.left.node= T

    def rebalance(self):
        self.update_heights(False)
        self.update_balances(False)
        while self.balance< -1 or self.balance>1:
            if self.balance>1 : #check if there is imbalance on the left side of the tree
                if self.node.left.balance <0: # (LR imbalance)
                    self.node.left.lrotate()
                    self.update_heights()
                    self.update_balances()
                self.rrotate()   #LL Imbalance
                self.update_heights()
                self.update_balances()
            if self.balance<-1:   # check if there is imbalance on the right side of the tree
                if self.node.right.balance>0:   #RL Imbalance
                    self.node.right.rrotate()
                    self.update_heights()
                    self.update_balances()
                self.lrotate()               #RR imbalance
                self.update_heights()
                self.update_balances()

    def Insert(self, key):
        tree= self.node
        new_node = Node(key)
        if(tree is None):
            self.node = new_node
            self.node.left = Tree()
            self.node.right = Tree()
        elif key< tree.key:
            self.node.left.Insert(key)
        elif key> tree.key:
            self.node.left.Insert(key)
        else:
            debug("Key ["+str(key)+"] is already in tree")
        self.rebalance()


    def check_balanced(self):
        if self == None or self.node == None:
            return True
        self.update_heights()
        self.update_balance()
        return ((abs(self.balance)<2)and self.node.left.check_balanced() and self.node.right.check_balanced())

    # def inorder_traversal(self):
    #     if self !=None and self.node!=None:
    #         inlist = []
    #         l = self.node.left.inorder_traversal()
    #         for i in l:
    #             inlist.append(i)
    #         inlist.append(self.node.key)
    #         l =self.node.right.inorder_traersal()
    #         for i in l:
    #             inlist.append(i)
    #         return inlist

a= [i for i in range(1000)]
for i in range(len(a)):
    j = random.randint(0,len(a)-1)
    a[i], a[j]= a[j], a[i]

T = Tree()
for i in a:
    T.Insert(a[i])


#T.inorder_traversal()
