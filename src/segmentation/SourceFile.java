/**
* ���ķִʣ��������ƥ���㷨
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SourceFile {
	
	private static SinglyLinkedList lexicon=new SinglyLinkedList();
	private static StringBuffer article=new StringBuffer();

	private void readSourceFile(FileInputStream fis,SinglyLinkedList wordsList){
		try{
		   InputStreamReader dis=new InputStreamReader(fis);
		   BufferedReader reader=new BufferedReader(dis);
		   String s;
		   while((s=reader.readLine())!=null){
			   //System.out.println("���ڶ�ȡ������"+s);
			   wordsList.append(s);
		   }
		   dis.close();
		}
		
		catch(IOException e){
			System.out.println("��ȡ��������");
			System.exit(1);
		}
	}
	private void readSourceFile(FileInputStream fis,StringBuffer article){
		try{
			InputStreamReader dis=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(dis);
			String s;
			while( (s=reader.readLine())!=null){
				article.append(s);
			}
			dis.close();
		}
		catch(IOException e){
			System.out.println("��ȡarticle.txt����!");
			System.exit(1);
		}
	}
	
	public void readLexicon() throws IOException{
		String lexiconFileName="lexicon3.txt";//�������ָ����ͬ�Ĵʿ�
		System.out.println("��ʼ��ȡ�ʿ�"+lexiconFileName+"��");
		this.readSourceFile( new FileInputStream(lexiconFileName), lexicon);
		System.out.println("��ȡ�ʿ����");
	}
	public SinglyLinkedList getLexicon(){
		return lexicon;
	}
	
	public void readArticle()throws IOException{
		System.out.println("��ȡ���ִ��ı�article.txt;");
		this.readSourceFile(new FileInputStream("article.txt"),article);
		System.out.println("��ȡ���;");
		
	}
	public String getArticle(){
		return article.toString();
	}
	

}
