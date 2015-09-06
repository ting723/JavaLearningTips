package com.zhanglw.tips.exception;

import com.zhanglw.tips.base.TestTips;

@SuppressWarnings("serial")
class Annoyance extends Exception {}
@SuppressWarnings("serial")
class Sneeze extends Annoyance {}

// �쳣: �ȴ�����󵽸���
public class ExceptionTest implements TestTips{
	 private void xn() 
		        throws Exception {
		        try {
		            try {
		                throw new Sneeze();
		            } 
		            catch ( Annoyance a ) {
		            	// a = new Sneeze();(�����滻ԭ��)
		                System.out.println("Caught Annoyance");
		                throw a;//���׳�����new Sneeze()
		            }
		        } 
		        catch (Sneeze s) {
		            System.out.println("Caught Sneeze");
		            //��ִ��finally,��return
		            return ;
		        }
		        finally {
		            System.out.println("Hello World!");
		        }
		    }

	@Override
	public void test() {
		try {
			this.xn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
