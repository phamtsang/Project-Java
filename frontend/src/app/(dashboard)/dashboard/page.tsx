import { DashboardOverview } from '@/components/dashboard/dashboard-overview';

export default function DashboardPage() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold">Tổng quan</h1>
        <p className="text-muted-foreground">
          Xem tổng quan hoạt động kinh doanh của bạn
        </p>
      </div>
      <DashboardOverview />
    </div>
  );
}
