/**
* ���ķִʣ��������ƥ���㷨
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ResultFile {
	public void saveProcessedArticle(String result){
		try{
			FileOutputStream fos=new FileOutputStream("result.txt");
			OutputStreamWriter dos=new OutputStreamWriter(fos);
			BufferedWriter writer=new BufferedWriter(dos);
			writer.write(result);
			writer.flush();
			dos.close();
		}catch( IOException e){
			System.out.println("�������ķִʽ��ʱ����!");
		}
	}
}
