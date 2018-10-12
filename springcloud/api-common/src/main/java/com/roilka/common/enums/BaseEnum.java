package com.roilka.common.enums;

import java.io.Serializable;

/**
 * 
* 类名: BaseEnum.java
* 包名 : com.roilka.common.enums
* 详细描述: 枚举基类
* 开发人员： zhanghui1
* 开发日期：2018年10月11日 下午9:13:22
*
 */
public interface BaseEnum <D> extends Serializable{
    
    public D getDesc();


}
