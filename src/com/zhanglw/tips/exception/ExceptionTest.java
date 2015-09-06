package com.zhanglw.tips.exception;

import com.zhanglw.tips.base.TestTips;

@SuppressWarnings("serial")
class Annoyance extends Exception {}
@SuppressWarnings("serial")
class Sneeze extends Annoyance {}

// 异常: 先从子类后到父类
public class ExceptionTest implements TestTips{
	 private void xn() 
		        throws Exception {
		        try {
		            try {
		                throw new Sneeze();
		            } 
		            catch ( Annoyance a ) {
		            	// a = new Sneeze();(里氏替换原则)
		                System.out.println("Caught Annoyance");
		                throw a;//故抛出的是new Sneeze()
		            }
		        } 
		        catch (Sneeze s) {
		            System.out.println("Caught Sneeze");
		            //先执行finally,再return
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
