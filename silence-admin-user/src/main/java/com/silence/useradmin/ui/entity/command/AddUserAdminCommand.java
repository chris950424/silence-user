package com.silence.useradmin.ui.entity.command;

import lombok.Data;

/**
 * UserVo
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@Data
public class AddUserAdminCommand {
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
