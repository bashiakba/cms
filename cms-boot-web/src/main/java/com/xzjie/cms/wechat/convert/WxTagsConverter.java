package com.xzjie.cms.wechat.convert;

import com.xzjie.cms.core.convert.Converter;
import com.xzjie.cms.wechat.dto.WxTagsResult;
import com.xzjie.cms.wechat.model.WxTags;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = Converter.componentModel, uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WxTagsConverter extends Converter<WxTagsResult, WxTags> {
}
