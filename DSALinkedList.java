import java.io.Serializable;
import java.util.*;
/* 
    IMPLEMENTED AND ATAPTED FROM PRAC 3
                                        */
public class DSALinkedList implements Iterable, Serializable
{
    private DSAListNode head;
    private DSAListNode tail;
    int count;
    
    public DSALinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }
    
    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }        
    
    public int getCount()
    {
        return count;
    }

    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);

        if (isEmpty()) 
        {   
            tail = newNd;
            head = tail;
        } else 
        {
            newNd.setNext(null);
            newNd.setPrev(tail);
            tail.setNext(newNd);
            tail = newNd;
        }
        count++;
    }
    public boolean isEmpty()
    {
        boolean empty = ((head == null) && (tail == null));
        return empty;
    }
    
    public Object removeFirst()
    {
        Object nodeValue = null;
        if (isEmpty()) 
        {
            throw new IllegalArgumentException("list is empty (rF)");
        } 
        else 
        {
            nodeValue = head.getValue();
            head = head.getNext();
            if(head == null)
            {
                tail = null;
            }    
            else
            {
                head.setPrev(null);
            }
            count--;
        }
        return nodeValue;
    }
    public Object removeLast()
    {
        Object nodeValue = null;

        if (isEmpty()) 
        {
            throw new IllegalArgumentException("list is empty (rmL)");    
        } else
        {
            nodeValue = tail.getValue();
            tail = tail.getPrev(); 
            if(tail == null)
            {
                head = null;
            }
            else
            {
                tail.setNext(null);
            }
            count--;
        }
              
        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue = null;

        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty, please add an element to view");
        }
        else
        {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    public void printList()
    {
        DSAListNode currNd = head;
        System.out.println("============================");

        while (currNd != null) 
        {
            System.out.format("%s\n", (String)currNd.getValue());
            currNd = currNd.getNext();    
        }
    }

    public void iterateOverList(DSALinkedList list)
    {
        DSALinkedList c;
        Iterator iter = list.iterator();
        while (iter.hasNext()) 
        {
            c = (DSALinkedList)iter.next();
                
        }
    }
//////////////////////////////////////////////////////////////////////////////
    
    private class DSAListNode implements Serializable  //private inner class
    {
        private Object value;
        private DSAListNode next;
        private DSAListNode prev;

        public DSAListNode(Object inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }

        public Object getValue()
        {
            return value;
        }
        public void setValue(Object inValue)
        {
            value = inValue;
        }
        public DSAListNode getNext()
        {
            return next;
        }
        public void setNext(DSAListNode newNext)
        {
            next = newNext;
        }
        public DSAListNode getPrev()
        {
            return prev;
        }
        public void setPrev(DSAListNode newPrev)
        {
            prev = newPrev;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;

        public DSALinkedListIterator(DSALinkedList list)
        {
            iterNext = list.head;
        }
        public boolean hasNext()
        {
            return (iterNext != null);
        }
        public Object next()
        {
            Object value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }
    } 
}