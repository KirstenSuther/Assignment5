# binary search program makefile
# Hussein Suleman
# 27 March 2017

JAVAC=/usr/bin/javac
JAVA=usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class 
	BinaryTree.class 
	BTQueueNode.class BTQueue.class 
	BinarySearchTree.class 
	BinarySearchTreeTest.class 
	Posts.class Account.class 
         
CLASS_FILES= $(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm %(BINDIR)/%.class
	
run: $(CLASS_FILES)
	$(JAVA) -cp bin BinarySearchTreeTest
