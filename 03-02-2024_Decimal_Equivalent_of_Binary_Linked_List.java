class Solution
{
   long DecimalValue(Node head)
   {
        long num = 0;
        Node temp = head;
        while(temp != null)
        {
            num = (num*2 + temp.data) % 1000000007;
            temp = temp.next;
        }
        return num;
   }
}
