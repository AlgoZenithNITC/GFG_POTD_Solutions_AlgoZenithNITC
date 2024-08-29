class Solution:
    def find_loop_length(self, start):
        current_node = start
        visited_nodes = set()

        while current_node is not None:
            if current_node in visited_nodes:
                loop_length = 1
                temp_node = current_node.next
                while temp_node != current_node:
                    loop_length += 1
                    temp_node = temp_node.next
                return loop_length

            visited_nodes.add(current_node)
            current_node = current_node.next

        return 0
