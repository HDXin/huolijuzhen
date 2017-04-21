package com.sudaotech.mobile.web;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.config.ConfigLoader;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;

/**
 * APP检查更新
 */
@Path("/app/update")
public class MobileAppUpdateResource extends BaseResource {
    private static final Comparator<Update> UPDATE_COMPARATOR = new Comparator<Update>() {
        @Override
        public int compare(Update u1, Update u2) {
            int n = compareVersion(u1.version, u2.version);
            return n;
        }
    };

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Update> checkUpdate(
            @NotNull(message = "app required") @QueryParam("app") String app,
            @NotNull(message = "app version required") @Pattern(regexp="[0-9\\.]+") @QueryParam("version") String version) throws IOException {
        Update update = null;
        UpdateConfig updateConfig = ConfigLoader.loadYamlAs("app-update.yaml", UpdateConfig.class);
        List<Update> updates = updateConfig.getUpdates();
        if (!CollectionUtils.isEmpty(updates)) {
            Collections.sort(updates, UPDATE_COMPARATOR);
            for (int i = updates.size() - 1; i >= 0; i--) {
                Update item = updates.get(i);
                if (!StringUtils.equalsIgnoreCase(item.getApp(), app)) {
                    continue;
                }
                
                if (compareVersion(item.version, version) > 0) {
                    update = item;
                    break;
                }
            }
        }
        
        if (update == null) {
            update = new Update();
            update.app = app;
            update.version = version;
        }
        
        return new Result<Update>(ResultCode.OK, update);
    }

    /**
     * 比较版本。
     * v1 大于 v2：返回正数;
     * v1 等于 v2：返回零;
     * v1 小于 v2：返回正数;
     * @param v1
     * @param v2
     * @return
     */
    private static final int compareVersion(String v1, String v2) {
        String[] a1 = StringUtils.split(v1, ".");
        String[] a2 = StringUtils.split(v2, ".");
        for (int i = 0; i < a1.length && i < a2.length; i++) {
            int a = Integer.parseInt(a1[i]);
            int b = Integer.parseInt(a2[i]);
            int c = a - b;
            if (c == 0) {
                continue;
            }
            
            return c;
        }
        
        return a1.length - a2.length;
    }
    
    public static class UpdateConfig {
        private List<Update> updates;
        public List<Update> getUpdates() {
            return updates;
        }
        public void setUpdates(List<Update> updates) {
            this.updates = updates;
        }
    }
    
    public static class Update {
        private String app;
        private String version;
        private String url;
        private String title;
        private String content;
        public String getApp() {
            return app;
        }
        public void setApp(String app) {
            this.app = app;
        }
        public String getVersion() {
            return version;
        }
        public void setVersion(String version) {
            this.version = version;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Update [app=").append(app).append(", version=").append(version).append(", url=")
                    .append(url).append(", title=").append(title).append(", content=").append(content).append("]");
            return builder.toString();
        }
    }
}
