package io.qiantan.server.infrastructure.mail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @author yujiacheng
 * @date 2019/8/154:15 PM
 */
@Data
@Builder
@ApiModel("邮件实体类")
public class MailInfo {

    @ApiModelProperty(value = "邮件发送人", position = 1)
    private String from;

    @ApiModelProperty(value = "邮件接收人", position = 2)
    private String to;

    @ApiModelProperty(value = "邮件主题", position = 3)
    private String subject;

    @ApiModelProperty(value = "邮件内容", position = 4)
    private String content;

    @ApiModelProperty(value = "邮件类型", position = 5)
    private String type;

    @ApiModelProperty(value = "发送邮件模板时的模板文件名", position = 6)
    private String templateName;

    @ApiModelProperty(value = "模板参数", position = 7)
    private Map<String,Object> variables;

    @ApiModelProperty(value = "附件地址", position = 8)
    private String attachPath;

}
