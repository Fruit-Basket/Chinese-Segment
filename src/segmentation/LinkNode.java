/**
* ���ķִʣ��������ƥ���㷨
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

public class LinkNode                             //���������࣬Tָ������Ԫ������
{
    public String data;                               //�����򣬱�������Ԫ��
    public LinkNode next;                         //��ַ�����ú�̽��
    

    public LinkNode(String data, LinkNode next)            //�����㣬dataָ������Ԫ�أ�nextָ����̽��
    {
        this.data = data;
        this.next = next;
    }
    public LinkNode()
    {
        this(null, null);
    }
}
