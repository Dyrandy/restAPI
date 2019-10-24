package com.rest.domain.projection;

import com.rest.domain.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "getOnlyName", types= { User.class })
public interface UserOnlyContatinName {
    String getName();
}
