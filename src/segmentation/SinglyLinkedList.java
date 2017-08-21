/**
* ���ķִʣ��������ƥ���㷨
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

public class SinglyLinkedList {
	private LinkNode head,rear;
	
	public SinglyLinkedList(){
		this.head=this.rear=new LinkNode();
	}
	
	public boolean isEmpty(){
		return this.head.next==null;
	}
	
	//���ؽ����
	public int length(){
		int i=0;
		LinkNode p=this.head.next;
		while(p!=null){
			i++;
			p=p.next;
		}
		return i;
	}
	
	//���ص�i��Ԫ�ص�ֵ��i��1��ʼ����
	public String get(int i){
		LinkNode p=this.head;
		while (i>0&&p!=null){
			p=p.next;
			--i;
		}
		if(p!=null)
		   return p.data ;
		return null;
	}
	
	//��Ԫ�ز��뵽����β��
	public void append(String e){
		LinkNode p=new LinkNode();
		p.data=e;
		this.rear.next=p;
		this.rear=p;
	}

}
