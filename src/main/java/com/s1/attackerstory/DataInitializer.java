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
import com.s1.attackerstory.user.UserRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements SmartInitializingSingleton {
    private final UserRepository users;

    private final MarketingInfoRepository marketingInfo;

    public DataInitializer(UserRepository users, MarketingInfoRepository marketingInfo) {
        this.users = users;
        this.marketingInfo = marketingInfo;
    }

    @Override
    public void afterSingletonsInstantiated() {
        User admin = this.users
                .save(new User(1L, "Mary", "Admin", "mary@marketing.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", true));
        User ria = this.users
                .save(new User(2L, "Ria", "Stein", "ria@example.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User kate = this.users
                .save(new User(3L, "Kate", "Griggs", "kate@example.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User henri = this.users
                .save(new User(4L, "Henri", "Ex", "henri@hacker.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User brenda = this.users
                .save(new User(5L, "Brenda", "Jenkins", "bjenkins@thebank.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User kathleen = this.users
                .save(new User(6L, "Kathleen", "Diaz", "kdiaz@app.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User joshua = this.users
                .save(new User(7L, "Joshua", "Thompson", "driverjt@shipit.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User michael = this.users
                .save(new User(8L, "Michael", "Smith", "numbersguy@cpas.net", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User nancy = this.users
                .save(new User(9L, "Nancy", "Davis", "ringring@rings.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User pamela = this.users
                .save(new User(10L, "Pamela", "Williams", "pwilliams@teach.edu", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User laura = this.users
                .save(new User(11L, "Laura", "Henderson", "ceo@coolthing.io", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User cynthia = this.users
                .save(new User(12L, "Cynthia", "Hill", "chill@brushstrokes.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User patricia = this.users
                .save(new User(13L, "Patricia", "Perez", "pperez@blankpages.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User james = this.users
                .save(new User(14L, "James", "Rivera", "jriv@punch.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User lisa = this.users
                .save(new User(15L, "Lisa", "Young", "lisay@news.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User john = this.users
                .save(new User(16L, "John", "Brown", "johnbrown@automo.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));
        User steven = this.users
                .save(new User(17L, "Steven", "Baker", "sbaker@email.com", "{bcrypt}$2a$10$S7IvdytcrRStALljsyZmp.OUIfqCiJTD.WeeFfotlt6fOs8F8/QNC", false));

        this.marketingInfo.save(new MarketingInfo(ria, "Software Engineer", "78701"));
        this.marketingInfo.save(new MarketingInfo(kate, "Product Manager", "20745"));
        this.marketingInfo.save(new MarketingInfo(henri, "Hacker", "94103"));
        this.marketingInfo.save(new MarketingInfo(brenda, "Banker", "89158"));
        this.marketingInfo.save(new MarketingInfo(kathleen, "Designer", "20001"));
        this.marketingInfo.save(new MarketingInfo(joshua, "Logistics", "75202"));
        this.marketingInfo.save(new MarketingInfo(michael, "Accountant", "95054"));
        this.marketingInfo.save(new MarketingInfo(nancy, "Jeweler", "48060"));
        this.marketingInfo.save(new MarketingInfo(pamela, "Teacher", "11572"));
        this.marketingInfo.save(new MarketingInfo(laura, "Founder", "02474"));
        this.marketingInfo.save(new MarketingInfo(cynthia, "Artist", "36301"));
        this.marketingInfo.save(new MarketingInfo(patricia, "Writer", "10512"));
        this.marketingInfo.save(new MarketingInfo(james, "Fitness Instructor", "33056"));
        this.marketingInfo.save(new MarketingInfo(lisa, "Journalist", "11530"));
        this.marketingInfo.save(new MarketingInfo(john, "Auto Sales", "52001"));
        this.marketingInfo.save(new MarketingInfo(steven, "Server", "13027"));
    }
}
