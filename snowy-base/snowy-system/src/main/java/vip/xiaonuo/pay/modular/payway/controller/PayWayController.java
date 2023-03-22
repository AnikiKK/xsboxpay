
/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Snowy源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
6.若您的项目无法满足以上几点，可申请商业授权，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package vip.xiaonuo.pay.modular.payway.controller;

import vip.xiaonuo.core.annotion.BusinessLog;
import vip.xiaonuo.core.annotion.Permission;
import vip.xiaonuo.core.enums.LogAnnotionOpTypeEnum;
import vip.xiaonuo.core.pojo.page.PageResult;
import vip.xiaonuo.core.pojo.response.ResponseData;
import vip.xiaonuo.core.pojo.response.SuccessResponseData;
import vip.xiaonuo.pay.modular.payway.entity.PayWay;
import vip.xiaonuo.pay.modular.payway.param.PayWayParam;
import vip.xiaonuo.pay.modular.payway.service.PayWayService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * 支付方式表控制器
 *
 * @author abc
 * @date 2022-01-01 23:53:12
 */
@Controller
public class PayWayController {

    private String PATH_PREFIX = "pay/payWay/";

    @Resource
    private PayWayService payWayService;

    /**
     * 支付方式表页面
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @GetMapping("/payWay/index")
    public String index() {
        return PATH_PREFIX + "index.html";
    }

    /**
     * 支付方式表表单页面
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    @GetMapping("/payWay/form")
    public String form() {
        return PATH_PREFIX + "form.html";
    }

    /**
     * 查询支付方式表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @GetMapping("/payWay/page")
    @BusinessLog(title = "支付方式表_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public PageResult<PayWay> page(PayWayParam payWayParam) {
        return payWayService.page(payWayParam);
    }

    /**
     * 添加支付方式表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @PostMapping("/payWay/add")
    @BusinessLog(title = "支付方式表_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(PayWayParam.add.class) PayWayParam payWayParam) {
        payWayService.add(payWayParam);
        return new SuccessResponseData();
    }

    /**
     * 删除支付方式表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @PostMapping("/payWay/delete")
    @BusinessLog(title = "支付方式表_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(PayWayParam.delete.class) List<PayWayParam> payWayParamList) {
        payWayService.delete(payWayParamList);
        return new SuccessResponseData();
    }

    /**
     * 编辑支付方式表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @PostMapping("/payWay/edit")
    @BusinessLog(title = "支付方式表_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(PayWayParam.edit.class) PayWayParam payWayParam) {
        payWayService.edit(payWayParam);
        return new SuccessResponseData();
    }

    /**
     * 查看支付方式表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @GetMapping("/payWay/detail")
    @BusinessLog(title = "支付方式表_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(PayWayParam.detail.class) PayWayParam payWayParam) {
        return new SuccessResponseData(payWayService.detail(payWayParam));
    }

    /**
     * 支付方式表列表
     *
     * @author abc
     * @date 2022-01-01 23:53:12
     */
    
    @ResponseBody
    @GetMapping("/payWay/list")
    @BusinessLog(title = "支付方式表_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(PayWayParam payWayParam) {
        return new SuccessResponseData(payWayService.list(payWayParam));
    }

}