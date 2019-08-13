Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:
7 -- 15 -- 20
| |
3 9

BSTIterator iterator = new BSTIterator(root);
iterator.next(); // return 3
iterator.next(); // return 7
iterator.hasNext(); // return true
iterator.next(); // return 9
iterator.hasNext(); // return true
iterator.next(); // return 15
iterator.hasNext(); // return true
iterator.next(); // return 20
iterator.hasNext(); // return false
