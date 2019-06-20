package com.jalasoft.minions.tree;

/**
 * Created by OPTIMUS on 09/06/2019.
 */
public class CustomTree<T> {
    TreeNode<T> root;

    CustomTree(T value) {
        root = new TreeNode<T>(value);
    }

    public void add(T value) {
        addNode(new TreeNode<T>(value), root);
    }

    private void addNode(TreeNode node, TreeNode customRoot) {
        if (root == null) {
            root = node;
        } else {
            if (root.value.getClass().toString().length() >= compareTo(node).length()) {
                if (customRoot.rigth == null) {
                    customRoot.rigth = node;
                } else {
                    addNode(node, customRoot.rigth);
                }
            } else {
                if (root.value.getClass().toString().length() < compareTo(node).length()) {
                    if (customRoot.left == null) {
                        customRoot.left = node;
                    } else {
                        addNode(node, customRoot.left);
                    }
                }
            }
        }
    }

    public void printTree() {
        if (root != null) {
            System.out.println(root);
            if (root.left == null) {
                printNode(root.rigth);
            } else {
                if (root.rigth == null) {
                    printNode(root.left);
                }
            }
            printNode(root.left);
            printNode(root.rigth);
        }
    }

    private void printNode(TreeNode node) {
        if (node.left == null && node.rigth == null) {
            System.out.println(node.value);
        } else {
            if (node.rigth == null) {
                printNode(node.left);
            } else {
                if (node.left == null) {
                    printNode(node.rigth);
                } else {
                    printNode(node.rigth);
                    printNode(node.left);
                }
            }
        }
    }

    public void addBalance(T value) {
        TreeNode node = new TreeNode<>(value);
        if (root == null) {
            root = null;
            node.setHigh();
        } else {

        }
    }

    private void addNodeBalance(TreeNode node, TreeNode customRoot) {
        if (root == null) {
            root = node;
        } else {
            if (root.value.getClass().toString().length() >= compareTo(node).length()) {
                if (customRoot.rigth == null) {
                    customRoot.rigth = node;
                } else {
                    addNode(node, customRoot.rigth);
                }
            } else {
                if (root.value.getClass().toString().length() < compareTo(node).length()) {
                    if (customRoot.left == null) {
                        customRoot.left = node;
                    } else {
                        addNode(node, customRoot.left);
                    }
                }
            }
            if (root.left.getHigh() - root.rigth.getHigh() == -2) {
                customRoot = rotateLeft(customRoot);
                addNode(node, customRoot);
            } else {
                if (root.left.getHigh() - root.rigth.getHigh() == 2) {
                    customRoot = rotateRigth(customRoot);
                    addNode(node, customRoot);
                }
            }
        }
    }

    private TreeNode rotateRigth(TreeNode customRoot) {
        TreeNode aux = customRoot.rigth;
        customRoot.rigth = customRoot.left;
        aux.left = customRoot;
        customRoot.high = Math.max(customRoot.left.high, customRoot.rigth.high);
        aux.high = Math.max(aux.left.high, aux.rigth.high);
        return aux;

    }

    private TreeNode rotateLeft(TreeNode customRoot) {
        TreeNode aux = customRoot.left;
        customRoot.left = customRoot.rigth;
        aux.rigth = customRoot;
        customRoot.high = Math.max(customRoot.left.high, customRoot.rigth.high);
        aux.high = Math.max(aux.left.high, aux.rigth.high);
        return aux;

    }

    public void deleteNode(TreeNode node, T value) {
        if (root.value.getClass().toString().length() >= compareTo(node).length())
            deleteNode(root.left, value);

        else if (root.value.getClass().toString().length() < compareTo(node).length())
            deleteNode(root.rigth, value);

        else {
            if ((node.left == null) || (node.rigth == null)) {
                TreeNode temp = null;
                if (temp == root.left)
                    temp = root.rigth;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                TreeNode temp = minValueNode(node.rigth);

                // Copy the inorder successor's data to this node
                node.value = temp.value;

                // Delete the inorder successor
                deleteNode(root.rigth, (T) temp.value);
            }
        }
    }

    public TreeNode<T> removeNode(T value) {
        if (root.value.getClass().toString().length() >= compareTo(new TreeNode(value)).length())
            deleteNode(root.left, value);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (root.value.getClass().toString().length() < compareTo(new TreeNode(value)).length())
            deleteNode(root.rigth, value);

            // if key is same as root's key, then this is the node
            // to be deleted
        else {

            // node with only one child or no child
            if ((root.left == null) || (root.rigth == null)) {
                TreeNode temp = null;
                if (temp == root.left)
                    temp = root.rigth;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                TreeNode temp = minValueNode(root.rigth);

                // Copy the inorder successor's data to this node
                root = new TreeNode<>(value);

                // Delete the inorder successor
                deleteNode(root.rigth, (T) temp.value);
            }
        }

        root.high = Math.max((root.left.high), (root.rigth.high)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRigth(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRigth(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.rigth) <= 0)
            return rotateLeft(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.rigth) > 0) {
            root.rigth = rotateRigth(root.rigth);
            return rotateLeft(root);
        }

        return root;
    }

    private TreeNode minValueNode(TreeNode<T> node) {
        TreeNode current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    int getBalance(TreeNode node) {
        if (node == null)
            return 0;
        return node.left.high - node.rigth.high;
    }

    public TreeNode findNode(T value) {
        if (root != null) {
            if (root.value.equals(value)) {
                return root;
            } else {
                if (root.value.getClass().toString().length() < (compareTo(new TreeNode(value)).length())) {
                    return findNodeValue(value, root.left);
                } else {
                    return findNodeValue(value, root.rigth);
                }
            }
        } else
            return null;
    }

    private TreeNode findNodeValue(T value, TreeNode<T> node) {
        if (node.value.equals(value)) {
            return node;
        } else {
            return findNodeValue(value, node.left);
        }
    }

    private String compareTo(TreeNode node) {
        return node.value.getClass().toString();
    }
}
