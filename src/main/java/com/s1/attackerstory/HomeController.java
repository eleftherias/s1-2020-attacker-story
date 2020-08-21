/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.s1.attackerstory;

import com.s1.attackerstory.marketinginfo.MarketingInfo;
import com.s1.attackerstory.marketinginfo.MarketingInfoRepository;
import com.s1.attackerstory.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    final MarketingInfoRepository marketingInfo;

    public HomeController(MarketingInfoRepository marketingInfo) {
        this.marketingInfo = marketingInfo;
    }

    @GetMapping("/admin/home")
    String admin(Map<String, Object> model) {
        Iterable<MarketingInfo> marketingInfo = this.marketingInfo.findAll();
        model.put("marketingInfo", marketingInfo);
        return "admin";
    }

    @GetMapping("/customer/home")
    String user(@AuthenticationPrincipal User currentUser, Map<String, Object> model) {
        MarketingInfo currentUserMarketingInfo = marketingInfo.findMarketingInfoByOwnerId(currentUser.getId());
        model.put("marketingInfo", currentUserMarketingInfo);
        return "customer";
    }
}
