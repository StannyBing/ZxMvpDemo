/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.stanny.zxmvpdemo.api;

public class ApiConstants {

    //测试地址:  http://47.93.44.161:80/shop
    // 正式地址:  www.htxysc.com:8080/shop
    public static boolean ISRELEASE = false;// 是否正式环境
    public static final String RELEASE_URL = ISRELEASE ? "http://v.juhe.cn/" : "http://v.juhe.cn/";
                                                              //必须以http://开头，且结尾必须为反斜线/


}
