// import appConsts from '@/constants';
import appConsts from '@/constants/AppConstants';
import { setCookieValue, getCookieValue } from './cookieUtils';
import { useAuthStore } from '@/stores/AuthStore';

/**
 * Sets the authorization token cookie for the user.
 * @param authToken The authorization token we need to the set the cookie for.
 * @param expireDate The expiration date of this token
 */
export const setCookie = (
  authToken: string,
  cookieName?: string,
  expireDate?: Date
): void => {
  var cookie = {
    cookieName: cookieName ?? appConsts.tokenCookieName,
    authToken: authToken,
    expireDate: expireDate
  }

  setCookieValue(
    cookieName ?? appConsts.tokenCookieName,
    authToken,
    expireDate
  );
};

/**
 * Gets the authorization token for the user.
 * Returns null if there is no auth token.
 */
export const getToken = (cookieName?: string): string | null => {
  return getCookieValue(cookieName ?? appConsts.tokenCookieName);
  // return useAuthStore().getAccessToken;
};

/**
 * Clears the auth token for the user.
 */
export const clearToken = (): void => {
  setCookie('');
  setCookie('', 'RefreshToken');
};