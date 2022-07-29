package cn.yt4j.data.scope;

import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import org.springframework.util.StringUtils;

/**
 * 处理
 *
 * @author gyv12345@163.com
 */
@Slf4j
public class DefaultDataScopeHandler implements DataScopeHandler {
    @SneakyThrows
    @Override
    public Expression getSqlSegment(Expression where, DataScope dataScope) {
        SaUserCache saUserCache = StpUtil.getSession().getModel(SecurityConstants.SECURITY_PREFIX, SaUserCache.class);
        String sql;
        Expression sqlSegmentExpression;
        switch (DataScopeType.parse(saUserCache.getDataScope())) {
            case ALL:
                log.debug("不做权限处理");
                break;
            case MY_SELF:
                sql = StringUtils.hasText(dataScope.getAlias()) ? dataScope.getAlias() + ".create_user_id=%s" : "create_user_id=%s";
                sql = String.format(sql, saUserCache.getId());
                sqlSegmentExpression = CCJSqlParserUtil.parseCondExpression(sql);
                return new AndExpression(where, sqlSegmentExpression);
            case MY_DEPARTMENT:
                sql = StringUtils.hasText(dataScope.getAlias()) ? dataScope.getAlias() + "." + dataScope.getColumnName() + "=%s" : dataScope.getColumnName() + "=%s";
                sql = String.format(sql, saUserCache.getId());
                sqlSegmentExpression = CCJSqlParserUtil.parseCondExpression(sql);
                return new AndExpression(where, sqlSegmentExpression);
            default:
                break;
        }
        return where;
    }
}
