/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { AxiosError, AxiosRequestConfig, AxiosResponse } from 'axios';
import axios from '@/utils/axios';
import appConsts from '@/constants/AppConstants';
import { useAuthStore } from '@/stores/AuthStore';
import { clearToken, getToken } from '@/utils/tokenUtils';
import { deleteCookie } from '@/utils/cookieUtils';
import router from '@/router';

export const SetAuthHeader = () => {
  var token = getToken();
  if (!token) {
    ClearAuthHeader();
    return;
  }
  axios.defaults.headers.common.Authorization = `Bearer ${token}`;
};

export const ClearAuthHeader = () => {
  if (axios.defaults.headers.common.Authorization) {
    delete axios.defaults.headers.common.Authorization;
    return;
  }
}

export default class Endpoint {
  private endpoint: string;

  constructor(baseEndpoint?: string) {
    this.endpoint = `${appConsts.apiBaseUrl}${baseEndpoint ?? ''}`;
    SetAuthHeader();
    //if server thows unauthorized error, log user out
    axios.interceptors.response.use(
      (response: AxiosResponse) => response,
      (error: AxiosError) => {
        debugger
        if (error.response && error.response.status === 401) {
          ClearAuthHeader();
          clearToken();
          router.replace('/login');
        }
      }
    );
  }

  protected get = <T = any, R = AxiosResponse<{ result: T }>>(
    url?: string,
    config?: AxiosRequestConfig
  ): Promise<R> => axios.get<T, R>(`${this.endpoint}${url ?? ''}`, config);

  protected delete = <T = any, R = AxiosResponse<{ result: T }>>(
    url?: string,
    config?: AxiosRequestConfig
  ): Promise<R> => axios.delete<T, R>(`${this.endpoint}${url ?? ''}`, config);

  protected post = <T = any, R = AxiosResponse<{
    [x: string]: string; result: T
  }>>(
    url?: string,
    data?: any,
    config?: AxiosRequestConfig
  ): Promise<R> =>
    axios.post<T, R>(`${this.endpoint}${url ?? ''}`, data, config);

  protected put = <T = any, R = AxiosResponse<{ result: T }>>(
    url?: string,
    data?: any,
    config?: AxiosRequestConfig
  ): Promise<R> =>
    axios.put<T, R>(`${this.endpoint}${url ?? ''}`, data, config);

  protected patch = <T = any, R = AxiosResponse<{ result: T }>>(
    url?: string,
    data?: any,
    config?: AxiosRequestConfig
  ): Promise<R> =>
    axios.patch<T, R>(`${this.endpoint}${url ?? ''}`, data, config);


}
