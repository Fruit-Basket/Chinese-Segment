/**
* 中文分词：逆向最大匹配算法
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

import java.io.IOException;

public class WordsHandle {
	public static final int MAXLEN=4;    //词条的最大长度，每个汉字两个字节
	private static String result;
	
	public void handle(){    //完成整个处理，包括：读取文件、分词、保存结果
		this.getProcessedArticle();
		ResultFile resultFile=new ResultFile();
		resultFile.saveProcessedArticle(result);
		System.out.println("分词结果: "+result);
	}
	
	private void getProcessedArticle(){    //读取文件、分词，结果暂存在result中
		SourceFile sourceFile=new SourceFile();
		try {
			sourceFile.readArticle();
			sourceFile.readLexicon();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		System.out.println("正在分词中......");
		segment(sourceFile.getArticle(),sourceFile.getLexicon());
        System.out.println("分词完毕；");
	}
	
	private void segment(String article,SinglyLinkedList lexicon){    //使用逆向最大匹配法分词，结果存放在result
         int article_len=article.length(); 
         String subString;
         int offset;
         
         while(article!=null&&article_len>0){
        	 if(article_len>MAXLEN){
        	     subString=article.substring(article_len-MAXLEN,article_len);
        	 }
        	  else{
        		 subString=article.substring(0,article_len);
        	 }
        	offset=inLexicon(subString,lexicon);
        	 article_len-=offset;
         }
         result=result.substring(0,result.length()-9);    //去除后缀
	}
	
	private int inLexicon(String subString,SinglyLinkedList lexicon){    //查找某一字符串以及其子串是否在词库中
		int subString_len=subString.length();
		int lexicon_len=lexicon.length();
		String temp=null;
		int i,j;
		for(i=0;i<subString_len;i++){     //制作子串
			for(j=1;j<=lexicon_len;j++){    //遍历词库
				//System.out.println("正在搜索词条："+lexicon.get(j));
				if( (temp=subString.substring(i)).equals( lexicon.get(j) ) ==true ){
					result=temp+"  /  "+result;    //此处result会多出一个"null"，在segment中去除
					return MAXLEN-i;
				}
			}
		}
		result=temp+"  /  "+result;
		return 1;
	}
	
}
