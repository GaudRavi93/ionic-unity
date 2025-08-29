import { registerPlugin } from '@capacitor/core';

export interface UnityPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

const Unity = registerPlugin<UnityPlugin>('Unity');

export default Unity;
