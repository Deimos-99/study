package com.example;

/**
 * 日志切面
 * joinpoint(连接点):指哪些目标函数可以被拦截、例如sayHello
 * pointcut(切入点):指对joinPoint中哪些目标函数进行切入
 * advice(通知):在某个特点的pointcut(切入点)上需要执行的动作(代码)
 *              如日志、权限验证等具体要应用切入点的代码
 * aspect(切面): 由切点和通知相结合而成，定义通知应用到哪些切入点上
 * weaving(织入):把切面的代码应用到目标函数的过程
 */
public aspect HelloAspectDemo {

	// 切点
	pointcut recordLog():call(* HelloWorld.sayHello(..));

	/**
	 * 前置通知 --> 目标方法执行前执行
	 * before(参数):连接点函数 {
	 * 	 函数体
	 * }
	 */
	before():recordLog() {
		System.out.println("..前置通知:日志测试...");
	}

	/**
	 * 后置通知 --> 目标方法执行后执行
	 * after(参数):连接点函数 {
	 * 	 函数体
	 * }
	 */
	after():recordLog() {
		System.out.println("..后置通知:日志测试123....");
	}

	/**
	 * 异常通知 --> 目标方法抛出异常时执行
	 * after(参数) throwing(返回值类型):连接点函数 {
	 * 	 函数体
	 * }
	 */
	after() throwing(Exception e):recordLog() {
		System.out.println("异常通知" + e);
	}

	/**
	 * 后置返回通知 --> 目标方法返回时执行
	 * after(参数)returning(返回值类型):连接点函数 {
	 * 	 函数体
	 * }
	 */
	after() returning(Object obj):recordLog() {
		System.out.println("..后置返回通知:日志测试456...." + obj);

	}

	/**
	 * 环绕通知 可通过proceed()控制目标函数是否执行
	 * Object around(参数):连接点函数 {
	 *   函数体
	 *   Object result=proceed();//执行目标函数
	 *   return result;
	 *  }
	 */
	/*Object around():recordLog() {
		System.out.println("before hello");
		Object obj = null;
		try {
			obj = proceed();
		} catch (Exception e) {
			System.out.println("exception hello");
		}
		System.out.println("after hello");
		return obj;
	}*/

}
