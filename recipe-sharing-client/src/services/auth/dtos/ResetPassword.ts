export interface ResetPasswordDto {
    UserName: string;
    Token: string;
    NewPassword: string;
    NewPasswordConfirm: string;
  }
  