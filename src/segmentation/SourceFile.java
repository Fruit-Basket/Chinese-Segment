/**
* 中文分词：逆向最大匹配算法
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
			   //System.out.println("正在读取词条："+s);
			   wordsList.append(s);
		   }
		   dis.close();
		}
		
		catch(IOException e){
			System.out.println("读取词条出错！");
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
			System.out.println("读取article.txt出错!");
			System.exit(1);
		}
	}
	
	public void readLexicon() throws IOException{
		String lexiconFileName="lexicon3.txt";//这里可以指定不同的词库
		System.out.println("开始读取词库"+lexiconFileName+"；");
		this.readSourceFile( new FileInputStream(lexiconFileName), lexicon);
		System.out.println("读取词库完毕");
	}
	public SinglyLinkedList getLexicon(){
		return lexicon;
	}
	
	public void readArticle()throws IOException{
		System.out.println("读取待分词文本article.txt;");
		this.readSourceFile(new FileInputStream("article.txt"),article);
		System.out.println("读取完毕;");
		
	}
	public String getArticle(){
		return article.toString();
	}
	

}
