package com.nuritech.stock.my_stock.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LoingUser 어노테이션 생성
 * 
 * @Target(ElementType.PARAMETER)
 * - 이 어노테이션이 생성될 수 있는 위치를 지정, PARAMETER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할 수 있음
 * 
 * @interface
 * - 이 파일을 어노테이션 클래스로 지정, LoginUser 라는 이름을 가진 어노테이션이 생성됨
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
