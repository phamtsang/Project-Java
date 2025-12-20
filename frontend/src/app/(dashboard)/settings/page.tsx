import { UserList } from '@/components/settings/user-list';
import { StoreSettings } from '@/components/settings/store-settings';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';

export default function SettingsPage() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold">Cài đặt</h1>
        <p className="text-muted-foreground">
          Quản lý nhân viên và cài đặt cửa hàng
        </p>
      </div>

      <Tabs defaultValue="users" className="space-y-4">
        <TabsList>
          <TabsTrigger value="users">Nhân viên</TabsTrigger>
          <TabsTrigger value="store">Cửa hàng</TabsTrigger>
        </TabsList>
        <TabsContent value="users" className="space-y-4">
          <UserList />
        </TabsContent>
        <TabsContent value="store" className="space-y-4">
          <StoreSettings />
        </TabsContent>
      </Tabs>
    </div>
  );
}
