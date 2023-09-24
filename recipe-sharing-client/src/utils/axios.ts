import Axios, { AxiosError } from 'axios';
import appConsts from '@/constants/AppConstants';
import router from '@/router/index';
import { SetAuthHeader } from '@/services/BaseEndPoint';
import { clearToken, getToken, setCookie } from './tokenUtils';

let refreshingToken = false;
const baseURL = appConsts.apiBaseUrl?.toString();

const axios = Axios.create({
  baseURL,
  timeout: 100000
});

// Intercept after received HTTP requests
// axios.interceptors.response.use(
//   (response) => response,
//   (error: AxiosError) => {
//     if (error.response && error.response.data) {
//       const code = error.response.status;
//       if (error.response.headers['token-expired'] && !refreshingToken) {
//         // need to run refresh
//         refreshingToken = true;
//         return axios
//           .post('api/TokenAuth/RefreshToken', {
//             token: getToken(),
//             refreshToken: getToken('RefreshToken')
//           })
//           .then((res) => {
//             const { refreshToken, token } = res.data.result;
//             const method = error.response?.config.method;
//             const url = error.response?.request.responseURL;
//             setCookie(refreshToken, 'RefreshToken');
//             setCookie(token);
//             SetAuthHeader();
//             return axios({
//               method,
//               url
//             });
//           })
//           .finally(() => (refreshingToken = false));
//       }
//       if (error.response.headers['token-expired'] && code === 401) {
//         clearToken();
//         return router.replace('/');
//       }
//       console.error(`[Axios Error]`, error.response);

//     } else {
//       // window.$message.error(`${error}`);
//       console.log(error);
//       // clearToken();
//       // return router.push('/');
//     }
//     return Promise.reject(error);
//   }
// );

export default axios;
