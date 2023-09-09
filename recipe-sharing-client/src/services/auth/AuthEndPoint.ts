import { clearToken, setCookie } from '@/utils/tokenUtils';
import Endpoint, { ClearAuthHeader, SetAuthHeader } from '../BaseEndPoint';
import { ResetPasswordDto } from './dtos/ResetPassword';
import { useAuthStore } from '@/stores/AuthStore';
import UserDTO from '../users/UserDto';

//#region request/response interfaces
export interface LoginRequestDto {
  usernameOrEmail: string;
  password: string;
}
export interface RegisterRequestDto {
  username: string;
  password: string;
  email: string;
}

export interface LoginResponse {
  user: UserDTO;
  accessToken: string;
  // accessToken: string;
  // refreshToken: string;
  // expiresInSeconds: number;
  // locationId: number;
}
//#endregion

export default class AuthEndPoint extends Endpoint {
  register = (data: RegisterRequestDto) =>
    this.post<LoginResponse>('/Register', data).then((res) => {
      debugger
      if (res.data.result.accessToken) {
        setCookie(res.data.result.accessToken);
        var authStore = useAuthStore();
        SetAuthHeader();
      }
    });
  login = (data: any) => {
    ClearAuthHeader();
    clearToken();
    return this.post<LoginResponse>('/Login', data).then((res) => {
      debugger
      var authStore = useAuthStore();

      setCookie(res.data.accessToken);
      SetAuthHeader();

      authStore.setAuthenticatedUser(res.data.user);
      var returnUrl = authStore.getReturnUrl;
      authStore.setReturnUrl(null);
      return returnUrl;
    });
  }
  confirmEmail = (data: string) => {
    return this.post<string>("/ConfirmEmail").then((res)=> res.data );
  };
  forgotPassword = (email: { UserNameOrEmailAddress: string }) =>
    this.post('/ForgotPassword', email);
}

export const Auth = new AuthEndPoint('/Auth');
