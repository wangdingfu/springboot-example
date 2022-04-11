package example.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @DESCPTION: 公共返回结果对象
 * @AUTOHR wangdingfu
 * @DATE 2022-04-05 22:47:51
 */
@Getter
@Setter
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;


    public static <T> CommonResult<T> success(T data){
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(0);
        commonResult.setMessage("请求成功");
        commonResult.setData(data);
        return commonResult;
    }
}
