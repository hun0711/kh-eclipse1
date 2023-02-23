import axios from "axios";

export const jsonDeptList = (params) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_CHAT_IP + "dept/jsonDeptList.st1",
        params: params,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};
/* rafce 단축키 - arrow function export default */
