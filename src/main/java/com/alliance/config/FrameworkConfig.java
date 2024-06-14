/**
 * @author Swetambari
 */

package com.alliance.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {



    long timeout();
    String url();
    String browser();
    String passed_steps_screenshot();
    String failed_steps_screenshot();
    String skipped_steps_screenshot();
    String runmode();
    String remoteUrl();
    String send_email_to_users();
    String override_reports();
    String open_reports_after_execution();
    String retry_failed_tests();


}
