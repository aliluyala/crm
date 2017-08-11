/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 测试
 * @author wangmingfeng
 *
 */

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student{
	
	private String name;
	private int age;
	private String studentNo;
/**
总结：
	1、如果没有添加@Setter注解，则LombokTest中的student示例无法使用setAge()等方法。
	使用lombok之后，省去了许多没必要的get，set，toString，equals，hashCode代码，简化了代码编写，减少了代码量。
	2、另外@Data注解的作用相当于 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode的合集。
	3、另外@Log 省去了在LombokTest中添加 getLogger的如下代码： 
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
*/
}