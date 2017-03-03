/**
 * Parent, Child and Tree
 * You are given the table Tree, whose schema is described below.
 *
 * Tree
 * Id is the id of a node of the tree and P_id is the id of its parent node.
 *   +---------+---------+
 *   |  Column |    Type |
 *   +---------+---------+
 *   |  id     | Integer |
 *   +---------+---------+
 *   | p_id    | Integer |
 *   +---------+---------+
 * Each node in the tree can be of one of three types
 * Leaf node, Root node and Inner node
 * Write a query to print the node id and type of the node. Sort your o/p by node id
 */

CREATE TABLE TREE (
  `id` int(3) NULL,
  `p_id` int(3) NULL
) ENGINE=InnoDB;
Insert into TREE  VALUES (100, NULL),(101, 100),(102, 100),(103, 101);


select Id, case when P_id is null then 'Root'
                when Id not in (select P_id from Tree where P_id is not null) then 'Leaf'
                else 'Inner'
           end as Type
from Tree;