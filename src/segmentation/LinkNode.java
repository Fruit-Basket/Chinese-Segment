/**
* 中文分词：逆向最大匹配算法
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

public class LinkNode                             //单链表结点类，T指定结点的元素类型
{
    public String data;                               //数据域，保存数据元素
    public LinkNode next;                         //地址域，引用后继结点
    

    public LinkNode(String data, LinkNode next)            //构造结点，data指定数据元素，next指定后继结点
    {
        this.data = data;
        this.next = next;
    }
    public LinkNode()
    {
        this(null, null);
    }
}
