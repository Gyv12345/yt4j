package cn.yt4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.yt4j.sys.api.entity.SysOssFile;
import cn.yt4j.sys.mapper.SysOssFileMapper;
import cn.yt4j.sys.service.SysOssFileService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 文件记录表(SysOssFile)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2023-12-18 22:19:48
 */
@Service
@RequiredArgsConstructor
public class SysOssFileServiceImpl extends ServiceImpl<SysOssFileMapper, SysOssFile> implements SysOssFileService {

    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public boolean save(FileInfo fileInfo) {
        SysOssFile detail = BeanUtil.copyProperties(fileInfo, SysOssFile.class, "metadata", "userMetadata", "thMetadata", "thUserMetadata", "attr");

        //这是手动获 元数据 并转成 json 字符串，方便存储在数据库中
        detail.setMetadata(valueToJson(fileInfo.getMetadata()));
        detail.setUserMetadata(valueToJson(fileInfo.getUserMetadata()));
        detail.setThMetadata(valueToJson(fileInfo.getThMetadata()));
        detail.setThUserMetadata(valueToJson(fileInfo.getThUserMetadata()));
        //这是手动获 取附加属性字典 并转成 json 字符串，方便存储在数据库中
        detail.setAttr(valueToJson(fileInfo.getAttr()));
        boolean success = save(detail);
        if (success) {
            fileInfo.setId(detail.getId().toString());
        }
        return success;
    }

    @Override
    @SneakyThrows
    public FileInfo getByUrl(String url) {
        SysOssFile detail = getOne(Wrappers.<SysOssFile>lambdaQuery().eq(SysOssFile::getUrl, url));
        FileInfo info = BeanUtil.copyProperties(detail, FileInfo.class, "metadata", "userMetadata", "thMetadata", "thUserMetadata", "attr");

        //这是手动获取数据库中的 json 字符串 并转成 元数据，方便使用
        info.setMetadata(jsonToMetadata(detail.getMetadata()));
        info.setUserMetadata(jsonToMetadata(detail.getUserMetadata()));
        info.setThMetadata(jsonToMetadata(detail.getThMetadata()));
        info.setThUserMetadata(jsonToMetadata(detail.getThUserMetadata()));
        //这是手动获取数据库中的 json 字符串 并转成 附加属性字典，方便使用
        info.setAttr(jsonToDict(detail.getAttr()));
        return info;
    }

    @Override
    public boolean delete(String url) {
        this.remove(Wrappers.<SysOssFile>lambdaQuery().eq(SysOssFile::getUrl, url));
        return true;
    }

    /**
     * 将指定值转换成 json 字符串
     */
    public String valueToJson(Object value) throws JsonProcessingException {
        if (value == null) {
            return null;
        }
        return objectMapper.writeValueAsString(value);
    }

    /**
     * 将 json 字符串转换成元数据对象
     */
    public Map<String, String> jsonToMetadata(String json) throws JsonProcessingException {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return objectMapper.readValue(json, new TypeReference<>() {
        });
    }

    /**
     * 将 json 字符串转换成字典对象
     */
    public Dict jsonToDict(String json) throws JsonProcessingException {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return objectMapper.readValue(json, Dict.class);
    }
}
