export interface ApplicationInfoDto {
    version: string;
    releaseDate: string;
    features: string;
    systemPermissions: string[];
  }
  
  export interface UserLoginInfoDto {
    id: number;
    name: string;
    userName: string;
    emailAddress: string;
    grantedPermissions: string[];
  }
  
  export interface GetCurrentLoginInformationOutput {
    application: ApplicationInfoDto;
    user: UserLoginInfoDto;
  }
  