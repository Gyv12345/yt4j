/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sa.enums;

import cn.yt4j.core.enums.IMessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@Getter
@AllArgsConstructor
public enum SaExceptionEnum implements IMessageStatus {

    NOT_ROLE(401, "您无权限进行操作"),
    NOT_PERMISSION(401, "您无权限进行操作"),
    ;

    private int code;

    private String message;

}
