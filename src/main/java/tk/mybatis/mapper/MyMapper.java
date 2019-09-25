package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自己的Mapper
 * 特别注意,该接口不会被扫描到,否则会报错
 *
 * Author: YuKee
 * Email: wang.zhen@frontsurf.com
 * Date: 2019/9/24
 * Desc:
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
